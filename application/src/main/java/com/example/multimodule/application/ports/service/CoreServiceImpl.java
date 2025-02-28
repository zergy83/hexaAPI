package com.example.multimodule.application.ports.service;

import com.example.multimodule.application.dto.UserCoreReponseDTO;
import com.example.multimodule.application.dto.UserCoreRequestDTO;
import com.example.multimodule.application.mappers.UserCoreRequestMapper;
import com.example.multimodule.application.model.UserCallTrace;
import com.example.multimodule.application.ports.CoreService;
import com.example.multimodule.service.dto.HorizontalGetRequestDTO;
import com.example.multimodule.service.dto.HorizontalGetResponseDTO;
import com.example.multimodule.service.model.UserCallRegister;
import com.example.multimodule.service.service.PersistService;
import com.example.multimodule.service.service.implV1.HorizontalService;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class CoreServiceImpl implements CoreService {
    private final HorizontalService horizontalService;
    private final PersistService persistService;

    private final UserCoreRequestMapper userCoreRequestMapper;

    public CoreServiceImpl(HorizontalService horizontalService, PersistService persistService, UserCoreRequestMapper userCoreRequestMapper) {
        this.horizontalService = horizontalService;
        this.persistService = persistService;
        this.userCoreRequestMapper = userCoreRequestMapper;
    }

    @Override
    public UserCoreReponseDTO processUserRequestFromControllerDomain(UserCoreRequestDTO userCoreRequestDTO) {

        //map UserCoreRequestDTO to model
        UserCallTrace callTrace = userCoreRequestMapper.asUserCallTrace(userCoreRequestDTO);

        //do stuff with userCoreRequestDTO ex. call anotherAPI
        int totalNumberOfCall = callAnotherAPI(callTrace.getUserName());
        callTrace.setCallTime(OffsetDateTime.now());

        //persist data
        UserCallRegister callRegister= new UserCallRegister();
        callRegister.setNumberOfCall(totalNumberOfCall);
        persistUserCall(callRegister);

        // fix response
        UserCoreReponseDTO userCoreReponseDTO = new UserCoreReponseDTO();
        userCoreReponseDTO.setCallDone(true);

        return userCoreReponseDTO;
    }

    @Override
    public void getFromDatabase() {

    }

    /**
     * Business logic method, I want to know the call count for this user, so I use Rest-domain module( a.k.a PORTS) to request another API
     * @param userName
     * @return result of my core logic
     */
    @Override
    public int callAnotherAPI(String userName) {
        HorizontalGetRequestDTO firstRequest = new HorizontalGetRequestDTO();

        //use rest-domain service
        HorizontalGetResponseDTO responseDTO= horizontalService.getCurrentCallNumberForThisUser(firstRequest);
        return responseDTO.getNumberOfCallForThisUser() + 1;
    }

    /**
     * I want to persist so I Use
     * @param callRegister
     */
    @Override
    public void persistUserCall(UserCallRegister callRegister) {
        persistService.save(callRegister);
    }
}
