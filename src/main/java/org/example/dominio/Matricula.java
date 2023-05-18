package org.example.dominio;


import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tb_matricula")
public class Matricula{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "_seq")
    @SequenceGenerator(name = "matricula_seq", sequenceName = "sq_matricula", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(name = "codigo", length = 10 ,nullable = false, unique = true )
    private String codigo;
    @Column(name = "data_matricula" ,nullable = false)
    private Instant dataMatricula = Instant.now();

    @Column(name = "valor_matricula",nullable = false)
    private Double valorMatricula;
    @Column(name = "status_matricula",nullable = false)
    private String statusMatricula;

    public Matricula() {
    }

    public Double getValorMatricula() {
        return valorMatricula;
    }

    public void setValorMatricula(Double valorMatricula) {
        this.valorMatricula = valorMatricula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Instant getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Instant dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getStatusMatricula() {
        return statusMatricula;
    }

    public void setStatusMatricula(String statusMatricula) {
        this.statusMatricula = statusMatricula;
    }
}
