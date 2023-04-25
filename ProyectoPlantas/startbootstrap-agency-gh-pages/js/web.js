window.addEventListener("load", () => {
    const element = document.getElementById("boton")
    element.addEventListener("click", async (event) => {
        event.preventDefault();
        const input = document.getElementById("buscador");//variable donde vamos a guardar la informacion
        const Plantas = input.value.trim();//eliminamos los espacios blancos
        const apiUrl = `http://localhost:9090/api/Plantas/search/${Plantas}`;//llamamos a la url
        let respuesta = await fetch(apiUrl)
        console.log(respuesta)
        let res = await respuesta.json()
        console.log(res);

        let plantas = "<div class='d-flex flex-wrap'>";
        for (let i = 0; i < res.length; i++) {
            let m = res[i];
            plantas += ` <div class="card w-25"> <img src="${m.fotos}" alt="Result 1">
        <h3>${m.nombre}</h3>
        <h5>Riego</h5><h4>${m.agua}</h4>
        <h5>Luz</h5><h4>${m.luz}</h4>
        <h5>Flor</h5><h4>${m.flor}</h4>
        <h5>Petfriendly</h5><h4>${m.petfriendly}</h4>
        <h5>Color</h5><h4>${m.color}</h4>
        


        <input type="hidden" id="nombre">
        <a href="#" id="agregar-favoritos"><i class="fa-regular fa-heart"></i>  Añadir a mi lista de deseos</a>
    </div>
`
        }

plantas+="</div>";
        let contenedor = document.getElementById("contenedor")
        contenedor.innerHTML = plantas
    }
    )
}
)