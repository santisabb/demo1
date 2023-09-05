package com.example.demo1.repositorios;

import com.example.demo1.entidades.Cancha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanchaRepository extends JpaRepository<Cancha , Integer> {
}
