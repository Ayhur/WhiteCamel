export interface Usuario {
    dni: string;
    nombre: string;
    apellidos: string;
    direccion: string;
    telefono: string;
    sexo: string;
    email: string;
    fecha_nacimiento: Date; // Usar el tipo Date para fechas
    usuario: string;
    password: string;
    localidad: string;
    provincia: string;
  }
  