package sales.admission.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sales.admission.domain.Admission;
import sales.admission.repository.AdmissionRepository;

import java.util.Date;

/**
 * Created by Myroslav on 14.08.2015.
 */
@Service
public class AdmissionServiceImpl implements AdmissionService {
    @Autowired
    private AdmissionRepository admissionRepository;
    @Override
    public void add(Admission admission) {
       admissionRepository.save(admission);
    }

    @Override
    public double getAdmissionForLastTime(Date date) {
        double sum = 0;
        for (Admission admission: admissionRepository.findByDateAfter(date))
        {
            sum+=admission.getSum();
        }
        return sum;
    }
}