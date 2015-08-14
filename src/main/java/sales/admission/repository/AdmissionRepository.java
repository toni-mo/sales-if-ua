package sales.admission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.admission.domain.Admission;

import java.util.Date;
import java.util.List;

/**
 * Created by Myroslav on 14.08.2015.
 */
public interface AdmissionRepository extends JpaRepository<Admission, Integer> {
    public List<Admission> findByDateAfter(Date date);
}
