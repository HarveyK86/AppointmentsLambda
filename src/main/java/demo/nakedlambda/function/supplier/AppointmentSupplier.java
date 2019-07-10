package demo.nakedlambda.function.supplier;

import demo.nakedlambda.repository.AppointmentRepository;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;

public final class AppointmentSupplier implements Supplier<String> {

  @Autowired
  private AppointmentRepository appointmentRepository;

  public AppointmentSupplier() {
    System.out.println("AppointmentSupplier");
  }

  @Override
  public String get() {
    System.out.println("AppointmentSupplier > (this).get");
    return this.appointmentRepository.findAll().toString();
  }

}