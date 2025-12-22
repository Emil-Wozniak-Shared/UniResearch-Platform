import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchInstitutions } from "../store/institutionsSlice";
import type { RootState, AppDispatch } from "../store/store";

interface Institution {
  id: string;
  name: string;
  type: string;
  location: string;
  university: string;
  foundedYear: number;
  scientificField: string;
}

export const InstitutionsPage: React.FC = () => {
  const dispatch = useDispatch<AppDispatch>();
  const { data, loading, error } = useSelector((state: RootState) => state.institutions);
  useEffect(() => {
    dispatch(fetchInstitutions());
  }, [dispatch]);

  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error}</div>;
  return (
    <div>
      <div className="flex justify-between items-center mb-6">
        <h2 className="text-2xl font-bold">Institutions</h2>
        <button className="bg-blue-600 hover:bg-blue-700 text-white px-4 py-2 rounded">
          Create Institution
        </button>
      </div>

      <div className="overflow-x-auto bg-white shadow rounded-lg">
        <table className="min-w-full divide-y divide-gray-200">
          <thead className="bg-gray-50">
            <tr>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Name</th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Type</th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Location</th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">University</th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Founded Year</th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Scientific Field</th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Actions</th>
            </tr>
          </thead>
          <tbody className="bg-white divide-y divide-gray-200">
            {data.map((i: Institution) => (
              <tr key={i.id}>
                <td className="px-6 py-4 whitespace-nowrap">{i.name}</td>
                <td className="px-6 py-4 whitespace-nowrap">{i.type}</td>
                <td className="px-6 py-4 whitespace-nowrap">{i.location}</td>
                <td className="px-6 py-4 whitespace-nowrap">{i.university}</td>
                <td className="px-6 py-4 whitespace-nowrap">{i.foundedYear}</td>
                <td className="px-6 py-4 whitespace-nowrap">{i.scientificField}</td>
                <td className="px-6 py-4 whitespace-nowrap">
                  <button className="text-blue-600 hover:underline mr-2">Edit</button>
                  <button className="text-red-600 hover:underline">Delete</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};
