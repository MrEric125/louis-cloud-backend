package com.louis.security.config;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/7/4
 * Description:
 */
/*@Component
public class AuthFailureHandler implements AuthenticationFailureHandler {

    @Autowired
    private ObjectMapper mapper;



    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        mapper.writeValue(response.getWriter(), ErrorResponse.of(e.getMessage(), ErrorCode.AUTHENTICATION, HttpStatus.UNAUTHORIZED));

    }
}*/
