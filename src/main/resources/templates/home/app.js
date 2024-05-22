import AppCursos from "./components/AppCursos.vue";
import AppDisciplina from "./components/AppDisciplina.vue";
import AppGradeHoraria from "./components/AppGradeHoraria.vue";
import AppProfessor from "./components/AppProfessor.vue";
import AppSala from "./components/AppSala.vue";
import AppTurma from "./components/AppTurma.vue";

const MyNameApp = {
    components: {
        AppDisciplina,
        AppGradeHoraria,
        AppProfessor,
        AppSala,
        AppTurma,
        AppCursos,
    },
};

Vue.createApp(MyNameApp).mount("#app");
