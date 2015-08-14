package sales.notification.service;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;
import sales.payment.dto.data.AnonymMultyPaymentDTO;
import sales.payment.dto.data.RegisteredMultiPaymentDTO;
import sales.storage.domain.Storage;
import sales.storage.service.StorageService;
import sales.users.domain.User;
import sales.users.service.UserService;

import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by taras on 31.07.15.
 */
@Service("notificationService")
public class NotificationServiceImpl implements NotificationService {
    final static Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);

    @Autowired
    StorageService storageService;

    @Autowired
    UserService userService;

    private JavaMailSender mailSender;
    private VelocityEngine velocityEngine;
    private List<Storage> storages;

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    public void register(User user) {
        sendConfirmationEmail(user);
    }

    public void notificateOrderAnonym(AnonymMultyPaymentDTO anonymMultyPaymentDTO) {
        getGoods(anonymMultyPaymentDTO.getGoodsId());
        sendNotificationOrder(anonymMultyPaymentDTO.getEmail(), anonymMultyPaymentDTO.getFirstName());
    }

    public void notificateOrderRegist(RegisteredMultiPaymentDTO registeredMultiPaymentDTO) {
        getGoods(registeredMultiPaymentDTO.getGoodsId());
        User user = userService.getById(registeredMultiPaymentDTO.getUserId());
        sendNotificationOrder(user.getEmail(), user.getFirstName());
    }

    private void getGoods(List<Long> ids) {
        storages = new ArrayList<Storage>();
        for (Long id : ids) {
            storages.add(storageService.get(id));
        }
    }

    private void sendConfirmationEmail(final User user) {
        logger.debug("Creating mail text for email confirmation");
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(user.getEmail());
                message.setFrom("salesifua@gmail.com");
                Map model = new HashMap();
                model.put("user", user);
                String text = VelocityEngineUtils.mergeTemplateIntoString(
                        velocityEngine, "email-template/registration-confirmation.vm", model);
                message.setText(text, true);
            }
        };
        this.mailSender.send(preparator);
    }

    private void sendNotificationOrder(String email, String firstName) {
        logger.debug("Creating mail text for order information");

        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(email);
                message.setFrom("salesifua@gmail.com");
                Map model = new HashMap();
                model.put("firstName", firstName);
                String goods = "";
                for(int i = 0; i < storages.size(); i++) {
                    goods += storages.get(i).getGood().getName() + "<br>";
                }
                model.put("goods", goods);
                String text = VelocityEngineUtils.mergeTemplateIntoString(
                        velocityEngine, "email-template/order-notification.vm", model);
                message.setText(text, true);
            }
        };
        this.mailSender.send(preparator);
    }
}
