import React from 'react';

export interface Grant {
  id: string;
  title: string;
  description?: string;
  grantNumber: string;
  startDate: string;
  endDate?: string;
  totalAmount: number;
  currency: string;
  agency: string; // display name instead of id
  scientificField: string; // display name instead of id
}

const mockGrants: Grant[] = [
  {
    id: '1',
    title: 'Quantum Research',
    description: 'Study of quantum entanglement',
    grantNumber: 'Q-2025-01',
    startDate: '2025-01-01',
    endDate: '2026-01-01',
    totalAmount: 150000,
    currency: 'USD',
    agency: 'NCN',
    scientificField: 'Physics',
  },
  {
    id: '2',
    title: 'AI in Medicine',
    description: 'AI algorithms for medical imaging',
    grantNumber: 'AI-2025-07',
    startDate: '2025-03-01',
    endDate: null,
    totalAmount: 200000,
    currency: 'EUR',
    agency: 'FNP',
    scientificField: 'Computer Science',
  },
];

export const GrantsPage: React.FC = () => {
  return (
    <div>
      <div className="flex justify-between items-center mb-6">
        <h2 className="text-2xl font-bold">Grants</h2>
        <button className="bg-blue-600 hover:bg-blue-700 text-white px-4 py-2 rounded">
          Create Grant
        </button>
      </div>

      <div className="overflow-x-auto bg-white shadow rounded-lg">
        <table className="min-w-full divide-y divide-gray-200">
          <thead className="bg-gray-50">
            <tr>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Title</th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Number</th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Agency</th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Scientific Field</th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Start Date</th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">End Date</th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Amount</th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Currency</th>
              <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Actions</th>
            </tr>
          </thead>
          <tbody className="bg-white divide-y divide-gray-200">
            {mockGrants.map((g) => (
              <tr key={g.id}>
                <td className="px-6 py-4 whitespace-nowrap">{g.title}</td>
                <td className="px-6 py-4 whitespace-nowrap">{g.grantNumber}</td>
                <td className="px-6 py-4 whitespace-nowrap">{g.agency}</td>
                <td className="px-6 py-4 whitespace-nowrap">{g.scientificField}</td>
                <td className="px-6 py-4 whitespace-nowrap">{g.startDate}</td>
                <td className="px-6 py-4 whitespace-nowrap">{g.endDate || '-'}</td>
                <td className="px-6 py-4 whitespace-nowrap">{g.totalAmount}</td>
                <td className="px-6 py-4 whitespace-nowrap">{g.currency}</td>
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
