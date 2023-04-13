window.onload = () => {
    IndexButtonService.getInstance().loginButtonOnclickEvent();
    IndexPrincipalEventService.getInstance().loginSuccessHeaderEvent();
}

class PrincipalApi {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new PrincipalApi();
        }

        return this.#instance;
    }

    getPrincipal() {
        let responseData = null;

        $.ajax({
            async: false,
            type: 'get',
            url: "/api/account/principal",
            dataType: "json",
            success: response => {
                responseData = response.data;
                console.log(responseData);
            },
            error: error => {
                console.log(error);
            }
        });

        return responseData;
    }
}

class IndexButtonService {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new IndexButtonService();
        }
        return this.#instance;
    }

    loginButtonOnclickEvent() {
        const infoLoginButton = document.querySelectorAll('.info-container-nav')[0];

        infoLoginButton.onclick = () => {
            location.href = '/account/login';
        }
    }
}

class IndexPrincipalEventService {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new IndexPrincipalEventService();
        }
        return this.#instance;
    }

    loginSuccessHeaderEvent() {
        const infoLoginNav = document.querySelectorAll('.info-container-nav')[0];
        const infoRegisterNav = document.querySelectorAll('.info-container-nav')[1];
        const principalData = PrincipalApi.getInstance().getPrincipal();

        if(principalData.userId !== null) {
            infoLoginNav.innerHTML = `
                <li><a href="javascript:void(0);" class="info-container-nav">${principalData.user.name}님</a></li>
            `;

            infoLoginNav.onclick = () => {
                location.reload();
            }

            infoRegisterNav.innerHTML = `
                <li><a href="javascript:void(0);" class="info-container-nav">로그아웃</a></li>
            `;

            infoRegisterNav.onclick = () => {
                // 사용자 정보 제거
                $.ajax({
                    type: 'POST',
                    url: '/logout',
                    success: () => {
                        // 로그아웃 성공시 로그인 페이지로 이동
                        location.replace("/account/login");
                    },
                    error: error => {
                        console.log(error);
                    }
                });
            }
        } else if(principalData.userId == null) {
            infoLoginNav.innerHTML = `
                <li><a href="javascript:void(0);" class="info-container-nav">로그인</a></li>
            `;

            infoRegisterNav.innerHTML = `
                <li><a href="javascript:void(0);" class="info-container-nav">회원가입</a></li>
            `;
        }

    }
}