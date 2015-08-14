package sales.admission.service;

import sales.admission.domain.Admission;

import java.util.Date;

/**
 * Created by Myroslav on 14.08.2015.
 */
public interface AdmissionService {
    public void add(Admission admission);

    public double getAdmissionForLastTime(Date date);
}
