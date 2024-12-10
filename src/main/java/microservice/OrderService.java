package microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Order createOrder(Order order) {
        // Appel au microservice Produits pour vérifier l'existence du produit
        String productServiceUrl = "http://localhost:8081/products/" + order.getProductId();
        ProductResponse product = restTemplate.getForObject(productServiceUrl, ProductResponse.class);

        if (product != null) {
            // Si le produit existe, sauvegarde la commande
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Produit introuvable");
        }
    }
}
