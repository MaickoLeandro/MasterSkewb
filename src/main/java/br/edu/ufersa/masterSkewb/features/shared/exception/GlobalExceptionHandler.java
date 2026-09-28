package br.edu.ufersa.masterSkewb.features.shared.exception;

import br.edu.ufersa.masterSkewb.features.algorithm.exceptions.InvalidMovesException;
import br.edu.ufersa.masterSkewb.features.algorithm.exceptions.NotSolvedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.net.URI;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //Erros de validação do Jakarta Bean Validation (@Valid).
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail tratarValidacao(MethodArgumentNotValidException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                "Um ou mais campos estão inválidos. Corrija e tente novamente."
        );
        problem.setType(URI.create("about:blank"));
        problem.setTitle("Erro de validação de dados de entrada");
        problem.setProperty("timestamp", Instant.now());
        Map<String, String> camposComErro = new HashMap<>();
        for (FieldError fe : ex.getBindingResult().getFieldErrors()) {
            camposComErro.put(fe.getField(), fe.getDefaultMessage());
        }
        problem.setProperty("erros", camposComErro);
        return problem;
    }

    //Erros de leitura do JSON (JSON malformado, tipo incompatível ou valor inválido para Enum).
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ProblemDetail tratarMensagemIlegivel(HttpMessageNotReadableException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                "O corpo da requisição é inválido ou contém dados malformatados. Verifique tipos de dados e valores de enum."
        );
        problem.setType(URI.create("about:blank"));
        problem.setTitle("Corpo da requisição ilegível");
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }

    // Violação de regra de negócio/duplicidade (HTTP 422 Unprocessable Entity)
    @ExceptionHandler(InvalidOperationException.class)
    public ProblemDetail tratarOperacaoInvalida(InvalidOperationException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.UNPROCESSABLE_ENTITY,
                ex.getMessage()
        );
        problem.setType(URI.create("about:blank"));
        problem.setTitle("Regra de negócio violada");
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }

    // Recurso não encontrado (HTTP 404 Not Found)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ProblemDetail tratarEntidadeNaoEncontrada(ResourceNotFoundException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );
        problem.setType(URI.create("about:blank"));
        problem.setTitle("Recurso não encontrado");
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }

    // Handler coringa para quaisquer outras exceções derivadas de NegocioException
    @ExceptionHandler(BusinessException.class)
    public ProblemDetail tratarNegocioGenerico(BusinessException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                ex.getMessage()
        );
        problem.setType(URI.create("about:blank"));
        problem.setTitle("Violação de regra de negócio");
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }

    @ExceptionHandler(InvalidMovesException.class)
    public ProblemDetail tratarInvalidMoves(InvalidMovesException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                ex.getMessage()
        );
        problem.setType(URI.create("about:blank"));
        problem.setTitle("Violação de regra de negócio");
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }

    @ExceptionHandler(NotSolvedException.class)
    public ProblemDetail tratarNotSolvedException(NotSolvedException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                ex.getMessage()
        );
        problem.setType(URI.create("about:blank"));
        problem.setTitle("Violação de regra de negócio");
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }
}
