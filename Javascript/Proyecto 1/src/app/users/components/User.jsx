import "./user.css";

export default function User({user}){

    //TO DO: Agregar estado de users
    //TO DO: Hay estilos con diferentes colores para cada uno de los estados
    //Dependiendo el color tienen que usar el className que corresponde
    
    return(
        <li key={user.id} className="user-item">
        <div className="user-content"> 
        <div className="user-info">
            <div className="user-avatar">
                <img src={`/img/${user.avatar}`} alt={`Foto de ${user.name}`} className="user-image"/>
            </div>
        <div className="user-details">
            <div className="user-name">{user.name}</div>
            <div className="user-email">{user.email}</div>
        </div>
        </div>
        </div>
        </li>
    );
}

