package sales.admission.service;

import org.springframework.beans.factory.annotation.Autowired;
import sales.admission.domain.Admission;
import sales.admission.repository.AdmissionRepository;

/**
 * Created by Myroslav on 14.08.2015.
 */
public class AdmissionServiceImpl implements AdmissionService {
    @Autowired
    private AdmissionRepository admissionRepository;
    @Override
    public void add(Admission admission) {
       admissionRepository.save(admission);
    }
}
