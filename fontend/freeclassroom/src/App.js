import { useEffect } from "react";
import { Outlet } from "react-router-dom";
import Header from "./components/Header/Header";
import Footer from "./components/Footer/Footer";
import "./assets/css/min.css";
import "./App.scss";
import '@fortawesome/fontawesome-free/css/all.min.css';


const App = () => {
  useEffect(() => {
    // Thêm CSS từ CDN
    const mdbCss = document.createElement("link");
    mdbCss.href = "https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.2/mdb.min.css";
    mdbCss.rel = "stylesheet";
    document.head.appendChild(mdbCss);

    const popper = document.createElement("script");
    popper.src = "https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js";
    popper.integrity = "sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo";
    popper.crossOrigin = "anonymous";
    popper.async = true;
    document.body.appendChild(popper);

    const bootstrap = document.createElement("script");
    bootstrap.src = "https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js";
    bootstrap.integrity = "sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6";
    bootstrap.crossOrigin = "anonymous";
    bootstrap.async = true;
    document.body.appendChild(bootstrap);

    // Cleanup function khi component unmount
    return () => {
      document.head.removeChild(mdbCss);
      document.body.removeChild(popper);
      document.body.removeChild(bootstrap);
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
