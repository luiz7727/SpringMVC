package com.example.springmvc.repository;

import com.example.springmvc.model.Categoria;
import com.example.springmvc.model.Produto;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.time.LocalDate;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {

}
