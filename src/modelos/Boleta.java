package modelos;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Boleta {
    
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
	@Persistent private Long idOrganizacion;
    @Persistent private Long idProducto; //BOLETA DE SOLO UN PRODUCTO
    @Persistent private String  ruc;
    @Persistent private String dni;
    @Persistent private String razonSocial;
    @Persistent private String direccion;
    @Persistent private int cantidad;
    @Persistent private int total;
   
	public Boleta(Long idOrganizacion, Long idProducto, String ruc, String dni, String razonSocial, String direccion,
			int cantidad, int total) {
		
		this.idOrganizacion = idOrganizacion;
		this.idProducto = idProducto;
		this.ruc = ruc;
		this.dni = dni;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.cantidad = cantidad;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdOrganizacion() {
		return idOrganizacion;
	}

	public void setIdOrganizacion(Long idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}

	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}    
    
}
