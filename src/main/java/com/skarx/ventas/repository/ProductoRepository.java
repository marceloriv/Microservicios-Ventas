package com.skarx.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skarx.ventas.model.Entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT SUM(p.stock) FROM Producto p")
    public abstract Long sumStock();
}
