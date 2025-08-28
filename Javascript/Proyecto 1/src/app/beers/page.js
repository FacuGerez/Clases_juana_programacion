import BeerList from "./components/BeerList";
import { beers } from "../data/mocs";

export default function BeerPage() {
  //TO DO: Llamar a la API
  return <BeerList beers={beers} />;
}
