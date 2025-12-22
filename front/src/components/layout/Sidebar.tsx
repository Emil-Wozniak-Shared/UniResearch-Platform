import { Link } from "react-router";

export const Sidebar = () => {
    const token = localStorage.getItem("token");
    const handleLogout = () => {
    localStorage.removeItem("token");
    window.location.href = "/login";
  };
    return (
      <aside className="w-64 bg-gray-900 text-white min-h-screen p-6 flex flex-col">
        <h1 className="text-2xl font-bold mb-8">UniResearch</h1>
        <nav className="flex flex-col space-y-3">
          <Link to="/" className="hover:text-gray-300">Dashboard</Link>
          <Link to="/researchers" className="hover:text-gray-300">Researchers</Link>
          <Link to="/institutions" className="hover:text-gray-300">Institutions</Link>
          <Link to="/grants" className="hover:text-gray-300">Grants</Link>
          <Link to="/publications" className="hover:text-gray-300">Publications</Link>
          <Link to="/infrastructure" className="hover:text-gray-300">Infrastructure</Link>
          {token ? (
              <button onClick={handleLogout} className="w-full text-left hover:text-gray-300 mt-4">
                Logout
              </button>
          ) : (<Link to="/login" className="hover:text-gray-300">Login</Link>)}
        </nav>
        <div className="mt-auto text-gray-400 text-sm">
          © 2025 UniResearch
        </div>
      </aside>
    );
}