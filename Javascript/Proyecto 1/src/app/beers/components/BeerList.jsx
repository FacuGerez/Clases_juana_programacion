import "./beers.css";
import Beer from "./Beer";

const BeerList = ({beers}) => {
    return (
        <div className="beer-list-container">
            <h2 className="beer-list-title">Nuestra Seleccion de Cervezas</h2>
            <div className="beer-grid">
                {
                    beers.map((beer) => 
                        (
                        <Beer key={beer.name} beer={beer} />
                        )
                    )
                }
            </div>
        </div>
    );
}

export default BeerList;

