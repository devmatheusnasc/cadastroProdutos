package com.matheuscruz.cadastro.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheuscruz.cadastro.domain.Pedidos;

@Repository
public interface PedidosRepository extends  JpaRepository<Pedidos, UUID>{

}
