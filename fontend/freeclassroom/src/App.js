import { useEffect } from "react";
import { Outlet } from "react-router-dom";
import Header from "./components/Header/Header";
import Footer from "./components/Footer/Footer";
import "./App.scss";


const App = () => {
  useEffect(() => {
    // Thêm CSS từ CDN
    const mdbCss = document.createElement("link");
    mdbCss.href = "https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.2/mdb.min.css";
    mdbCss.rel = "stylesheet";
    document.head.appendChild(mdbCss);
    
    return () => {
      document.head.removeChild(mdbCss);
    };
  }, []);

  return (
    <>
      <Header />
      <div className="container">
        <Outlet />
      </div>
      <Footer />
    </>
  );
};

export default App;
