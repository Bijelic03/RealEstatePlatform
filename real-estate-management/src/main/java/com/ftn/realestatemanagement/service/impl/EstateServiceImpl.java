package com.ftn.realestatemanagement.service.impl;

import com.ftn.realestatemanagement.dto.EstateDto;
import com.ftn.realestatemanagement.model.Image;
import com.ftn.realestatemanagement.model.PropertyType;
import com.ftn.realestatemanagement.model.SaleStatus;
import com.ftn.realestatemanagement.repository.EstateRepository;
import com.ftn.realestatemanagement.model.Estate;
import com.ftn.realestatemanagement.service.AgencyService;
import com.ftn.realestatemanagement.service.EstateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EstateServiceImpl implements EstateService {

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static/img";

    private final EstateRepository estateRepository;
    private final AgencyService agencyService;

    @Override
    public List<EstateDto> getAllEstates() {
        return estateRepository.findAll().stream().map(EstateDto::convertToDto).toList();
    }
    @Override
    public List<EstateDto> getAllActiveEstates(){
        return estateRepository.findAllByActive(true).stream().map(EstateDto::convertToDto).toList();
    }

    @Override
    public Estate getById(Long id) {
        return estateRepository.getReferenceById(id);
    }

    @Override
    public EstateDto getByIdDto(Long id){
        return  EstateDto.convertToDto(estateRepository.getReferenceById(id));
    }

    @Override
    public EstateDto createEstate(EstateDto estateDto, List<MultipartFile> imageFiles) {

        Estate estate = estateDto.convertToModel();
        estate.setAgency(agencyService.getById(estateDto.getAgencyId()));
        estate.setActive(true);
        estate.setImages(imageFiles.stream().map(image -> {

            StringBuilder fileName = new StringBuilder();
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, image.getOriginalFilename());
            fileName.append(image.getOriginalFilename());

            Path uploadPath = Paths.get(UPLOAD_DIRECTORY);
            if (!Files.exists(uploadPath)) {
                try {
                    Files.createDirectories(uploadPath);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Files.write(fileNameAndPath, image.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return Image.builder()
                    .imagePath(fileNameAndPath.toString())
                    .name(image.getOriginalFilename())
                    .estate(estate)
                    .build();

        }).toList());


        return EstateDto.convertToDto(estateRepository.save(estate));
    }

    @Override
    public EstateDto editEstate(EstateDto estateDto) {
        Estate estate = getById(estateDto.getId());
        estate.setArea( estateDto.getArea());
        estate.setActive(estateDto.isActive());
        estate.setName(estateDto.getName());
        estate.setPrice(estateDto.getPrice());
        estate.setPropertyType(estateDto.getPropertyType());
        estate.setSaleStatus(estateDto.getSaleStatus());
        estate.setLocation(estateDto.getLocation());

        return EstateDto.convertToDto(estateRepository.save(estate));
    }

    public void deleteEstate(Long id) {
        estateRepository.deleteById(id);
    }
    public List<EstateDto> searchEstates(String name, String city, Integer fromArea, Integer toArea,
                                         Double fromPrice, Double toPrice, PropertyType propertyType,
                                         SaleStatus saleStatus, Long agencyId) {

        System.out.println("Radim");

        return estateRepository.findByParams(name, fromArea, toArea, fromPrice, toPrice, propertyType,
                saleStatus, agencyId)
                .stream()
                .map(EstateDto::convertToDto)
                .toList();
    }

}