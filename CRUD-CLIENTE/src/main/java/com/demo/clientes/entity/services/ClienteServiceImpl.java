package com.demo.clientes.entity.services;

import com.demo.clientes.entity.dao.ClienteDao;
import com.demo.clientes.entity.domain.KpiClientes;
import com.demo.clientes.entity.models.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Slf4j
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    public Cliente get(long id) {
        return clienteDao.findById(id).get();
    }

    @Override
    public KpiClientes getKpiAllCustomers() {
        KpiClientes kpiClientes;
        @NotEmpty Integer edad;
        @NotEmpty Integer Float;
        float edadTotal = 0;
        @NotEmpty Integer sumdesvEstandar;
        double sum = 0;
        @NotEmpty Integer desvEstandar = null;
        ;
        DescriptiveStatistics descriptiveStatistics = null;
        List<Cliente> dsd = (List<Cliente>) clienteDao.findAll();
        Integer tamArray = dsd.size();
        log.info(" La cantidad de Clientes es {} ", tamArray);
        Integer kpi = 0;
        for (int i = 0; i < tamArray; i++) {
            edad = dsd.get(i).getAge();
            log.info("La edad de la persona {} es {}", i, edad);
            descriptiveStatistics = new DescriptiveStatistics();
            descriptiveStatistics.addValue(edad);
            log.info("la edad promedio es {}", descriptiveStatistics.getSum() / tamArray);
            log.info("la desviacion estandar es {} ", descriptiveStatistics.getStandardDeviation());


        }
        log.info("La edad total es {}", edadTotal);
        kpiClientes = new KpiClientes();
        kpiClientes.setPromedioEdad(descriptiveStatistics.getSum()/tamArray);
        //   kpiClientes.setDesvEstandar(desvEstandar);

        return kpiClientes;
    }

    @Override
    public List<Cliente> getAll() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    public void post(Cliente cliente) {
        clienteDao.save(cliente);

    }

    @Override
    public void put(Cliente cliente, long id) {
        clienteDao.findById(id).ifPresent((x) -> {
            cliente.setId(id);
            clienteDao.save(cliente);
        });
    }

    @Override
    public void delete(long id) {
        clienteDao.deleteById(id);
    }

}
