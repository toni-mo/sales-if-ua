package sales.images.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.images.domain.Image;

import java.util.List;

public interface ImageRepository extends JpaRepository <Image, Long> {

        public List<Image> findByGoodId(int goodId);

        public List<Image> findByGoodIdOrderByChainDesc(int goodId);

        public Image findByGoodIdAndChain(int goodId, int chain);
}
