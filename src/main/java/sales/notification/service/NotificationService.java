package sales.notification.service;

import sales.payment.dto.data.AnonymMultyPaymentDTO;
import sales.payment.dto.data.RegisteredMultiPaymentDTO;
import sales.users.domain.User;

/**
 * Created by taras on 31.07.15.
 */
public interface NotificationService {
    void register(User user);

    void notificateOrderAnonym(AnonymMultyPaymentDTO anonymMultyPaymentDTO);

    void notificateOrderRegist(RegisteredMultiPaymentDTO registeredMultiPaymentDTO);
}
