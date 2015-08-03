package sales.payment.paypal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.payment.paypal.domain.Paypal;

/**
 * Created by volodya on 28.07.15.
 */
public interface PaypalRepository extends JpaRepository<Paypal, Long> {

    public Paypal findById(long id);

    public void removeById(long id);

    public Paypal findByUserId(long id);

}
