import React from 'react';

interface Researcher {
  id: string;
  firstName: string;
  lastName: string;
  degree: string;
  university: string;
  institute: string;
}

const mockResearchers: Researcher[] = [
  {
    id: '1',
    firstName: 'John',
    lastName: 'Doe',
    degree: 'PhD',
    university: 'Uni Warsaw',
    institute: 'Physics',
  },
  {
    id: '2',
    firstName: 'Jane',
    lastName: 'Smith',
    degree: 'MSc',
    university: 'Uni Krakow',
    institute: 'Chemistry',
  },
];

export const ResearchersPage: React.FC = () => {
  return (
    <div>
      <div className="flex justify-between items-center mb-6">
        <h2 className="text-2xl font-bold">Researchers</h2>
        <button className="bg-blue-600 hover:bg-blue-700 text-white px-4 py-2 rounded">
          Create Researcher
        </button>
      </div>

      <div className="overflow-x-auto bg-white shadow rounded-lg">
        <table className="min-w-full divide-y divide-gray-200">
          <thead className="bg-gray-50">
            <tr>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                First Name
              </th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                Last Name
              </th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                Degree
              </th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                University
              </th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                Institute
              </th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                Actions
              </th>
            </tr>
          </thead>
          <tbody className="bg-white divide-y divide-gray-200">
            {mockResearchers.map((r) => (
              <tr key={r.id}>
                <td className="px-6 py-4 whitespace-nowrap">{r.firstName}</td>
                <td className="px-6 py-4 whitespace-nowrap">{r.lastName}</td>
                <td className="px-6 py-4 whitespace-nowrap">{r.degree}</td>
                <td className="px-6 py-4 whitespace-nowrap">{r.university}</td>
                <td className="px-6 py-4 whitespace-nowrap">{r.institute}</td>
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
