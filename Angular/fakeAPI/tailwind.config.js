/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}"
  ],
  theme: {
    extend: {
      colors:{
        primary:{
          100:'#B0ABAB',
          300:'#544F4F',
          500:'#252323',
          700:'#151414',
          900:'#0A0A0A'
        },
        secondary:{
          100:'#D5D9D3',
          300:'#ACB3A8',
          500:'#838D7C',
          700:'#51574C',
          900:'#292C26'
        },
        tertiary:{
          100:'#0AD6FF',
          300:'#00778F',
          500:'#002A32',
          700:'#002329',
          900:'#001114'
        },
      }
    },
  },
  plugins: [],
}

