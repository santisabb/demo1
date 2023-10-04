package com.example.demo1.repositorios;

import com.example.demo1.entidades.Parrilla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParrillaRepository extends JpaRepository<Parrilla, Long> {
}
