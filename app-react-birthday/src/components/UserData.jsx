import React, { useRef, useState, useEffect } from "react";
import EditSvg from "./svg/EditSvg";
import RemoveSvg from "./svg/RemoveSvg";
import ModalForm from "./ModalForm"; // Importa el componente ModalForm

const UserData = ({ visible, onClose }) => {
  const [editModalVisible, setEditModalVisible] = useState(false); // Estado para controlar la visibilidad del modal de edición
  const [formData, setFormData] = useState({
    name: "",
    lastName: "",
    birthdate: "",
    documentNumber: "",
    email: "",
    phone: "",
    statusDB: "",
  });

  const [userData, setUserData] = useState([]); // Arreglo para almacenar los datos de usuario
  const modalRef = useRef(null);

  const handleClickOutside = (event) => {
    if (modalRef.current && !modalRef.current.contains(event.target)) {
      onClose();
    }
  };

  const handleFormClick = (event) => {
    event.stopPropagation(); // Evita que el clic dentro del formulario se propague al contenedor del modal
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  // Función para abrir el modal de edición
  const handleEditModalOpen = () => {
    setEditModalVisible(true);
  };

  // Función para cerrar el modal de edición
  const handleEditModalClose = () => {
    setEditModalVisible(false);
  };

useEffect(() => {
  // Cargar los datos de usuario desde el localStorage al montar el componente
  const userDataFromLocalStorage = JSON.parse(localStorage.getItem("tasks"));
  console.log("userDataFromLocalStorage:", userDataFromLocalStorage);
  if (userDataFromLocalStorage) {
    setUserData(userDataFromLocalStorage);
  }
}, []);
  if (!visible) return null;

  return (
    <>
      <div
        className="fixed inset-0 flex justify-center items-center bg-black bg-opacity-30 backdrop-blur-sm z-50"
        onClick={handleClickOutside}
      >
        <div ref={modalRef} className="bg-white p-4 rounded-lg">
          <h2>User Data</h2>

          <ul>
            {userData.map((data) => (
              <li key={data.id}>
                <p>Name: {data.name}</p>
                <p>Last Name: {data.lastName}</p>
                <p>Birthdate: {data.birthdate}</p>
                <p>Document Number: {data.documentNumber}</p>
                <p>Email: {data.email}</p>
                <p>Phone: {data.phone}</p>
                <p>Status DB: {data.statusDB}</p>
                <p>Status: {data.status}</p>
                {/* Botón para abrir el modal de edición */}
                <div className="flex space-x-2">
                  <button
                    onClick={handleEditModalOpen}
                    className="text-blue-500"
                  >
                    <EditSvg />
                  </button>
                  <button className="text-red-500">
                    <RemoveSvg />
                  </button>
                </div>
              </li>
            ))}
          </ul>
        </div>
      </div>

      {/* ModalForm para la edición de datos */}

      <ModalForm visible={editModalVisible} onClose={handleEditModalClose} />
    </>
  );
};

export default UserData;
