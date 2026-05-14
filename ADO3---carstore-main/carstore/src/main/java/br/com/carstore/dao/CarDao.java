package br.com.carstore.dao;

import br.com.carstore.dto.CarDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarDao {

    private final JdbcTemplate jdbc;

    public CarDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final RowMapper<CarDTO> rowMapper = new RowMapper<>() {

        @Override
        public CarDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

            CarDTO dto = new CarDTO();

            dto.setId(rs.getLong("id"));
            dto.setName(rs.getString("name"));
            dto.setColor(rs.getString("color"));

            return dto;
        }
    };

    public List<CarDTO> findAll() {

        String sql = "SELECT * FROM car";

        return jdbc.query(sql, rowMapper);
    }

    public void save(CarDTO carDTO) {

        String sql = "INSERT INTO car(name, color) VALUES (?, ?)";

        jdbc.update(sql, carDTO.getName(), carDTO.getColor());
    }

    public void deleteById(Long id) {

        String sql = "DELETE FROM car WHERE id = ?";

        jdbc.update(sql, id);
    }

    public void update(Long id, CarDTO carDTO) {

        String sql = "UPDATE car SET name = ?, color = ? WHERE id = ?";

        jdbc.update(sql,
                carDTO.getName(),
                carDTO.getColor(),
                id);
    }

    public CarDTO findById(Long id) {

        String sql = "SELECT * FROM car WHERE id = ?";

        return jdbc.queryForObject(sql, rowMapper, id);
    }
}   