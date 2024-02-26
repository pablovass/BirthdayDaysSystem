import React, { useRef, useState, useEffect } from "react";
import EditSvg from './svg/EditSvg'; // Reemplaza con tu componente EditSvg real
import RemoveSvg from './svg/RemoveSvg'; // Reemplaza con tu componente RemoveSvg real

const UserData = ({ visible, users, onClose }) => {
  const [userData, setUserData] = useState([]); // Usa props para datos de usuario

  const modalRef = useRef(null);

  const handleClickOutside = (event) => {
    if (modalRef.current && !modalRef.current.contains(event.target)) {
      onClose();
    }
  };

  

  useEffect(() => {
    if (users) { // Comprueba si se proporcionan datos de usuario como prop
      setUserData(users); // Usa los datos de usuario proporcionados
    } else {
      // Obtiene datos de localStorage como alternativa (si es necesario)
      const userDataFromLocalStorage = JSON.parse(localStorage.getItem("userData"));
      if (userDataFromLocalStorage) {
        setUserData(userDataFromLocalStorage);
      }
    }
  }, [users]); // Actualiza la dependencia de useEffect si se obtienen datos de localStorage

  if (!visible) return null;

  return (
    <div
      className="fixed inset-0 flex justify-center items-center bg-black bg-opacity-30 backdrop-blur-sm z-50"
      onClick={handleClickOutside}
    >
      <div ref={modalRef} className="bg-white p-4 rounded-lg">
        <h2>Datos del usuario</h2>

        {userData.length > 0 && (
          <ul>
            {userData.map((user) => (
              <li key={user.id}>
                <p>Nombre: {user.name}</p>
                <p>Apellido: {user.lastName}</p>
                <p>Fecha de nacimiento: {user.birthdate}</p>
                <p>Número de documento: {user.documentNumber}</p>
                <p>Correo electrónico: {user.email}</p>
                <p>Teléfono: {user.phone}</p>
                <p>Estado DB: {user.statusDB}</p>
                <p>Estado: {user.status}</p>

                <div className="flex space-x-4">
                  <button>
                    <EditSvg />
                  </button>
                  <button>
                    <RemoveSvg />
                  </button>
                </div>
              </li>
            ))}
          </ul>
        )}

        {userData.length === 0 && <p>No se encontraron datos de usuario.</p>}

        {/* Aquí puedes agregar cualquier otro contenido o elementos del modal */}
      </div>
    </div>
  );
};

export default UserData;
