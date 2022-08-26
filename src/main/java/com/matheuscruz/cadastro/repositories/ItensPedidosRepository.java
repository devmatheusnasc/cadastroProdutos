package com.matheuscruz.cadastro.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheuscruz.cadastro.domain.ItensPedidos;

@Repository
public interface ItensPedidosRepository extends  JpaRepository<ItensPedidos, UUID>{

}
