package sales.paypal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.paypal.domain.Paypal;

/**
 * Created by volodya on 28.07.15.
 */
public interface PaypalRepository extends JpaRepository<Paypal, Integer> {

}
