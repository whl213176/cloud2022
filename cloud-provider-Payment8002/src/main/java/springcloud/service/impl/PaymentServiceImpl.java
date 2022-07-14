package springcloud.service.impl;

import com.hailong.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springcloud.dao.PaymentMapper;
import springcloud.service.PaymentService;

/**
 * @author wuhailong
 * @date 2022/5/23.
 */

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

  @Autowired
  PaymentMapper paymentMapper;

  @Override
  public int createPayment(Payment payment) {
    return paymentMapper.insertPayment(payment);
  }

  @Override
  public Payment selectPayment(long id) {
    return paymentMapper.selectPayment(id);
  }
}
