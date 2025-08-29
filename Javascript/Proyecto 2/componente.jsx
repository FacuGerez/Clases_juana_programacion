

// HTML, CSS, Javascript

function ejemploReact() {
  const miarray = ["hola", "como", "estas"];

  return (
    <div className="nombre-de-clase" style={{ color: 'blue', fontSize: '20px' }}>
      <h1 id="identificador">Hola mundo desde React</h1>
      {miarray.map((item, index) => (
        <p key={index}>{item}</p>
      ))}
    </div>
  );
}

export {ejemploReact};
