package dev.riv.REST_TurboBasic.services;

import dev.riv.REST_TurboBasic.modelDTOs.OrderDTO;
import dev.riv.REST_TurboBasic.modelHelpers.OrderProductQuantity;
import dev.riv.REST_TurboBasic.models.Order;
import dev.riv.REST_TurboBasic.repositories.OrderProductQuantityRepository;
import dev.riv.REST_TurboBasic.repositories.OrderRepository;
import dev.riv.REST_TurboBasic.repositories.ProductRepository;
import dev.riv.REST_TurboBasic.utilities.HashGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductQuantityRepository orderProductQuantityRepository;
    private final ProductRepository productRepository;
    private HashGenerator hashGenerator;

    @Autowired
    public OrderService (OrderRepository orderRepository, OrderProductQuantityRepository orderProductQuantityRepository, ProductRepository productRepository, HashGenerator hashGenerator) {
        this.orderRepository = orderRepository;
        this.orderProductQuantityRepository = orderProductQuantityRepository;
        this.productRepository = productRepository;
        this.hashGenerator = new HashGenerator();
    }

    public Order upsertOrder(OrderDTO orderDto) throws NoSuchAlgorithmException {

        double localPriceTotal = 0;

//        Set up a try block for this
        Order localOrder = orderRepository.findByOrderHash(orderDto.getOrderHash()); //what happens if this is null?
        if(localOrder.getOrderId() != 0) { orderDto.setOrderId(localOrder.getOrderId()); }
        if(orderDto.getOrderHash().equals("")) { orderDto.setOrderHash(hashGenerator.createMD5Hash()); }

        localOrder.setOrderId(orderDto.getOrderId());
        localOrder.setOrderHash(orderDto.getOrderHash());
        localOrder.setLinkedUserHash(orderDto.getLinkedUserHash());
        localOrder.setLinkedAddressHash(orderDto.getLinkedAddressHash());
        localOrder.setCustomerPayment(orderDto.getCustomerPayment());

        for(int i = 0; i < orderDto.getProductList().size(); i++) {
            OrderProductQuantity newOPQ = new OrderProductQuantity(
                    0,
                    orderDto.getOrderHash(),
                    orderDto.getProductList().get(i).getProductHash(),
                    orderDto.getProductQuantities().get(i)
            );
            localPriceTotal += productRepository.findByProductHash(newOPQ.getProductHash()).getPrice() * newOPQ.getProductQuantity();
            orderProductQuantityRepository.save(newOPQ);
        }

        localOrder.setPriceTotal(localPriceTotal);
        localOrder.setDollarDeficit(localOrder.getCustomerPayment() - localOrder.getPriceTotal());

        return orderRepository.save(localOrder);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    public void deleteOrderByOrderHash(String orderHash) {
        orderRepository.deleteByOrderHash(orderHash);
    }
}
