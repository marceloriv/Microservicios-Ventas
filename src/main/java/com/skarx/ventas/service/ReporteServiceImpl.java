package com.skarx.ventas.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.skarx.ventas.dto.Reporte;
import com.skarx.ventas.repository.PedidosRepository;
import com.skarx.ventas.repository.ProductoRepository;

@Service
public class ReporteServiceImpl implements ReporteService {

    private final PedidosRepository pedidosRepo;
    private final ProductoRepository productoRepo;

    public ReporteServiceImpl(PedidosRepository pedidosRepo, ProductoRepository productoRepo) {
        this.pedidosRepo = pedidosRepo;
        this.productoRepo = productoRepo;
    }

    @Override
    public Reporte ventasHoy() {
        long totalVentas = pedidosRepo.countByFecha(LocalDate.now());
        return new Reporte("Ventas", LocalDate.now(), totalVentas);
    }

    @Override
    public Reporte stockActual() {
        Long resultado = productoRepo.sumStock();
        long totalStock = (resultado != null) ? resultado : 0L;
        return new Reporte("Inventario", LocalDate.now(), totalStock);
    }
}
