"use client";

import UsersList from "./components/UserList";
import { useState, useEffect } from "react";

import React from "react";

export default function UsersPage() {
  //TO DO: Obtener los usuarios desde API. NOSE
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    //Funcion para obtener los usuarios de la API
    const fetchUsers = async () => {
      try {
        const response = await fetch(
          "https://raw.githubusercontent.com/ORT-PabloFernandez/PNTP2-REACT-EJEMPLO/main/src/data/usersv2.json",
        );
        const data = await response.json();
        setUsers(data);
        setLoading(false);
      } catch (error) {
        console.error("Error al cargar usuarios", error);
        setLoading(false);
      }
    };
    //Lamo a la funcion
    fetchUsers();
  }, []);
  return (
    <div className="container">
      {loading ? <p>Cargando usuarios...</p> : <UsersList users={users} />}
    </div>
  );
}
