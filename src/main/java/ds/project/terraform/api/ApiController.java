package ds.project.terraform.api;

import ds.project.terraform.api.dto.GetNoteDto;
import ds.project.terraform.api.dto.IPDto;
import ds.project.terraform.api.dto.IntroduceDto;
import ds.project.terraform.api.dto.PostNoteDto;
import ds.project.terraform.api.dto.TimeDto;
import ds.project.terraform.service.ApiService;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin()
public class ApiController {

    private final ApiService apiService;

    @GetMapping("/about")
    public ResponseEntity<IntroduceDto> getIntroduce() {
        return ResponseEntity.ok(new IntroduceDto("peter.kang(강동석)/클라우드"));
    }

    @GetMapping("/time")
    public ResponseEntity<TimeDto> getCategory() {
        return ResponseEntity.ok(
            new TimeDto(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)));
    }

    @PostMapping("/notes")
    public ResponseEntity<String> postNote(@RequestBody PostNoteDto dto) {
        apiService.postNote(dto);
        return ResponseEntity.ok("Good");
    }

    @GetMapping("/notes")
    public ResponseEntity<List<GetNoteDto>> getNote() {
        List<GetNoteDto> list = apiService.getNote();
        return ResponseEntity.ok(list);
    }
    @GetMapping
    public ResponseEntity<List<IPDto>> getIP() {
        List<IPDto> list = new ArrayList<>();
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();

                if (networkInterface.isLoopback() || !networkInterface.isUp()) {
                    continue;
                }

                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress inetAddress = addresses.nextElement();

                    if (inetAddress instanceof Inet4Address &&  !inetAddress.isLoopbackAddress()) {
                        list.add(IPDto.of(inetAddress.getHostAddress()));
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(list);
    }
}
