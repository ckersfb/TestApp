package app.autobuska.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.autobuska.model.Prevoznik;


@Repository
public interface PrevoznikRepository extends JpaRepository<Prevoznik, Long> {

}
