import User from "./User";
import "./user.css";

export default function UserList({ users }) {
  return (
    <div className="users-list-container">
      <ul className="user-list">
        {users.map((user) => (
          <User key={user.id} user={user} />
        ))}
      </ul>
    </div>
  );
}
