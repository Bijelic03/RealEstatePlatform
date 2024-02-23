/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ['./src/**/*.{js,jsx,ts,tsx}'],
  theme: {
    extend: {
      colors: {
        primary: {
          100: '#7890B0',
          500: '#3d5a80',
        },
        secondary: '#98c1d9 '
      },
    },
  },
  plugins: [],
}
