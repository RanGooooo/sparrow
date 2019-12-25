package model.temp.xxxxxxxxx.dao;

import model.temp.xxxxxxxxx.entity.Xxxxxxxxx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XxxxxxxxxRepository extends JpaRepository<Xxxxxxxxx,String>,CrudRepository<Xxxxxxxxx,String> {

    Xxxxxxxxx findXxxxxxxxxById(String id);

}
