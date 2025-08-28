"use client";
import { useState } from "react";
import "./beers.css";

export default function Beer({ beer }) {
  const [quantity, setQuantity] = useState(0);
  const [message, setMessage] = useState("");

  //TO DO Implementar handleMinus. BIEN
  //Implementarlo con un solo handle. LISTO
  //Validar que no pueda comprar 0 unidades. BIEN
  //Mejorar la leyenda de Has comprado.... con una unidad. BIEN

  const handleBuy = () => {
    if (quantity > 1) {
      setMessage(`Has comprado ${quantity} unidades de ${beer.name}`);
      setTimeout(() => setMessage(""), 3000);
    } else if (quantity == 0) {
      setMessage(`No se puede comprar ${quantity} unidades`);
      setTimeout(() => setMessage(""), 3000);
    } else {
      setMessage(`Has comprado ${quantity} unidad de ${beer.name}`);
      setTimeout(() => setMessage(""), 3000);
    }
  };

  return (
    <div className="beer-card">
      <div className="beer-image-container">
        <img
          src={beer.label}
          alt={`Etiqueta de ${beer.name}`}
          className="beer-image"
        />
      </div>
      <div className="beer-info">
        <h3 className="beer-name">{beer.name}</h3>
        <div>
          <p className="beer-details">
            <span>Tipo:</span>
            {beer.type}
          </p>
          <p className="beer-details">
            <span>ABV:</span>
            {beer.abv}%
          </p>
        </div>
        {/* Control de cantidad */}
        <div className="quantity-control">
          <span className="quantity-label">Cantidad:</span>
          <button
            onClick={() => setQuantity(quantity > 0 ? quantity - 1 : 0)}
            className="quantity-button quantity-button-left"
          >
            -
          </button>
          <span className="quantity-display">{quantity}</span>
          <button
            onClick={() => setQuantity(quantity + 1)}
            className="quantity-button quantity-button-right"
          >
            +
          </button>
        </div>
        {/* boton compra */}
        <button onClick={handleBuy} className="buy-button">
          Comprar
        </button>

        {/* Mensaje de confirmacion */}
        {message && <div className="success-mesage">{message}</div>}
      </div>
    </div>
  );
}
