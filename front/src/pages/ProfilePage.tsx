import React, { useEffect, useState } from "react";
import api from "../api/api";

interface UserProfile {
  username: string;
  roles: UserRole[];
  permissions: UserPermission[];
}

type UserRole = {
  name: string;
  description: string;
}

type UserPermission = {
  name: string;
  description: string;
}

export const ProfilePage: React.FC = () => {
  const [user, setUser] = useState<UserProfile | null>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchProfile = async () => {
      try {
        const token = localStorage.getItem("token");
        const response = await api.get("/api/me", {
          headers: { Authorization: `Bearer ${token}` }
        });
        setUser(response.data);
      } catch (err) {
        console.error(err);
      } finally {
        setLoading(false)
      }
    };

    fetchProfile();
  }, []);

  if (loading) return <div className="p-4">Loading...</div>;
  if (!user) return <div className="p-4 text-red-500">Unable to load profile</div>;

  return (
    <div className="max-w-md mx-auto bg-white shadow-lg rounded-2xl p-6 border border-gray-200">
    <h2 className="text-xl font-semibold text-gray-800 mb-2">Username</h2>
    <p className="text-gray-700 mb-4">{user.username}</p>

    <h3 className="text-lg font-medium text-gray-800 mb-2">Roles</h3>
    <div className="flex flex-wrap gap-2 mb-4">
      {user.roles.map((role) => (
        <span
          key={role.name}
          className="bg-blue-100 text-blue-800 text-sm font-medium px-3 py-1 rounded-full"
        >
          {role.description}
        </span>
      ))}
    </div>

    <h3 className="text-lg font-medium text-gray-800 mb-2">Permissions</h3>
    <div className="flex flex-wrap gap-2">
      {user.permissions.map((perm) => (
        <span
          key={perm.name}
          className="bg-green-100 text-green-800 text-xs font-medium px-2 py-1 rounded-full"
        >
          {perm.description}
        </span>
      ))}
    </div>
  </div>
  );
};
